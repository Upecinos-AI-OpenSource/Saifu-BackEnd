package com.upecinosai.saifu.platform.userContext.domain.model.commands;

public record CreatePersonCommand(String firstName,
                                  String lastName,
                                  String email,
                                  String street,
                                  String number) {
}
