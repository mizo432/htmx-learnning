package org.venuspj.htmx.shared.infra.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class IndexController {

  @GetMapping("/")
  public Mono<String> index(Model model) {
    Flux<String> flux = Flux
        .range(0, 10)
        .map(i -> "count :" + i)
        .repeat(10);
//        .delayElements(Duration.ofSeconds(1L));

    // data streaming, data driven mode.
    IReactiveDataDriverContextVariable reactiveDataDrivenMode =
        new ReactiveDataDriverContextVariable(flux, 1);

    model.addAttribute("items", reactiveDataDrivenMode);

    return Mono.just("index");

  }
}
