//package com.roms;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.github.benmanes.caffeine.cache.Caffeine;
//
//@Configuration
//public class CaffeineCacheConfig {
//	
//
//	@Bean
//	public Caffeine caffeine() {
//		
//		return caffeine().newBuilder()
//				.expireAfterAccess(60, TimeUnit.MINUTES);
//	}
//	
//	@Bean
//	public CacheManager cachemanager(Caffeine caffeine) {
//		
//	}
//	
//
//}
