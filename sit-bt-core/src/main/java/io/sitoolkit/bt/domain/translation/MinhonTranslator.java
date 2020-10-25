package io.sitoolkit.bt.domain.translation;

import com.jayway.jsonpath.JsonPath;
import io.sitoolkit.bt.infrastructure.config.AtConfig;
import io.sitoolkit.bt.infrastructure.web.WebClient;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MinhonTranslator implements Translator {

  private final WebClient webClient;

  private final AtConfig config;

  public String ja2en(String text) {
    Map<String, String> params = new HashMap<>();

    params.put("key", config.getApiKey());
    params.put("name", config.getUser());
    params.put("type", "json");
    params.put("text", text);
    String response =
        webClient.post("https://mt-auto-minhon-mlt.ucri.jgn-x.jp/api/mt/generalNT_ja_en/", params);

    return JsonPath.read(response, "$.resultset.result.text");
  }

  @Override
  public String en2ja(String text) {
    // TODO Auto-generated method stub
    return null;
  }
}
