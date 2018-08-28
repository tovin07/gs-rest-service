package hello;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.internal.samplers.ProbabilisticSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  @Bean
  public io.opentracing.Tracer tracer() {
    SamplerConfiguration sampler = new SamplerConfiguration()
        .withType(ProbabilisticSampler.TYPE)
        .withParam(1);
    return new Configuration("spring-boot").withSampler(sampler).getTracer();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
