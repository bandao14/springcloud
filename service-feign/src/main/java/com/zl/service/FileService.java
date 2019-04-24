package com.zl.service;

import com.zl.fileconfig.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "service-client",configuration = FeignSupportConfig.class)
public interface FileService {

    @RequestMapping(value = "file/upload",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
     String upload(@RequestPart(value = "file") MultipartFile file);
}
