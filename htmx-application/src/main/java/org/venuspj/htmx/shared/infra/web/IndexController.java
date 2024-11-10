package org.venuspj.htmx.shared.infra.web;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping("/")
  public String index(Model model) {
    List<String> recs = Lists.newArrayList();
    model.addAttribute("items", recs);
    // data streaming, data driven mode.

    return "index";

  }
}
