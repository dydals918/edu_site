package com.hkit.lifetime.company;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Company}
 */
public record CompanyDto(String name, String uuid) implements Serializable {
}