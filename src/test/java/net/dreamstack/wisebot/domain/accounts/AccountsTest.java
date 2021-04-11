package net.dreamstack.wisebot.domain.accounts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AccountsTest {

    @Test
    public void testAccountDeserialization() throws JsonProcessingException {
        String payload = "";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Accounts accounts = objectMapper.readValue(payload, Accounts.class);
        Assert.assertNotNull(accounts);
    }

}