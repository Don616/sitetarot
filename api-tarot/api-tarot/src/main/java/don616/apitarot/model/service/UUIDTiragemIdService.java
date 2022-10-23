package don616.apitarot.model.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDTiragemIdService {

    private UUID uuid;


    public UUID getUuid() {
        return uuid;
    }
}
