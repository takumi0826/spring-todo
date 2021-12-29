package com.example.todo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper;
  }

  // @Bean
  // PasswordEncoder passwordEncoder() {
  // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  // }
}
