package de.smartheating.eureka.scheduling;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

@Service
public class ScheduledOperations {
	
	Logger logger = LoggerFactory.getLogger(ScheduledOperations.class);

	@Scheduled(fixedDelayString = "30000")
	public void logInstances() {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
		List<Application> applications = registry.getApplications().getRegisteredApplications();
		
		for (Application application: applications) {
			List<InstanceInfo> infos = application.getInstances();
			for (InstanceInfo info: infos) {
				logger.info("AppName: " + info.getAppName() + "; InstanceID: " + info.getInstanceId() + "; IP:" + info.getIPAddr() + "; Port: " + info.getPort());
			}
		}
		
		logger.info("------------------------Break-----------------------");
	}
}
