package com.cngc.boot.data.etl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EtlInitListener.class)
public class EtlConfigurer {
}