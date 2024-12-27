# Getting Started

Currently, HomeAssistant does not allow limiting access to certain entities when creating a long-lived access token.
This is a security risk, as it allows anyone with the token to access all entities in HomeAssistant.

This small application solves this problem by creating a proxy between the client and HomeAssistant that allows
specifying which entities can be accessed.

