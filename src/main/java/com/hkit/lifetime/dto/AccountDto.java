package com.hkit.lifetime.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.hkit.lifetime.entity.Account}
 */
public record AccountDto(UUID uuid, String id, String pw, String birth, String email, String tel, String sex, String address1, String address2) implements Serializable {
}