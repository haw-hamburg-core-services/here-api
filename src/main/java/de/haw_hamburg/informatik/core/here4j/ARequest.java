package de.haw_hamburg.informatik.core.here4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public abstract class ARequest {

    Logger logger = LoggerFactory.getLogger(ARequest.class);

    private final String baseURL;
    private final String path;
    private final String resource;
    private final String format;
    private final String app_code;
    private final String app_id;
    private Properties properties = PropertyReader.readProperties();

    public ARequest(String baseURL, String path, String resource, String format) {
        this.baseURL = baseURL;
        this.path = path;
        this.resource = resource;
        this.format = format;
        this.app_code = properties.appCode;
        this.app_id = properties.appID;
    }

    protected <T> T request (Map<String, String> parameters, Class<T> responseType) throws URISyntaxException {
        T response = null;

        //build request url
        String request = baseURL + path + resource + "." + format +
                "?app_id=" + app_id +
                "&app_code=" + app_code;
        if(parameters != null){
            for (Map.Entry<String, String> parameter : parameters.entrySet()){
                request += "&" + parameter.getKey() + "=" + parameter.getValue();
            }
        }

        logger.info("Executing request: " + request);

        URI uri = new URI(request);
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.getForObject(uri, responseType);

        return response;
    }


}
