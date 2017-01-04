package com.bingkun.weixin.api.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterial implements Serializable {

    private String name;
    private File file;
    private String videoTitle;
    private String videoIntroduction;

    public Map<String, String> getForm() {
        Map<String, String> form = new HashMap<>();
        form.put("title", this.videoTitle);
        form.put("introduction", this.videoIntroduction);
        return form;
    }
}
