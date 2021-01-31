# Whoami

Simple application using spring boot and spring security to display details of the current keycloak user.

## Usage

In your keycloakrealm, create a new client `whoami`. Copy the client secret and update it in `application.properties`.
Also change the `keycloak.realm` and `keycloak.auth-server-url` according to your setup.

## Build

Run `./mvnw install`

## Start

Run `./mvnw spring-boot:run`

## Using groups in claims

To add realm roles in the `groups` claim, add `microprofile-jwt` to the default client scopes in the client configuration.

To add user groups in the `groups` claim, add a custom mapper "Group Memberships" on token claim name `groups` in the client configuration.

## Using Granted Authorities (spring-security)

If the property `keycloak.use-resource-role-mappings` is set to true, client roles are mapped to `GrantedAutority`s.

If this property is false, realm roles are mapped to `GrantedAuthority`s.

These granted authorities can be used in the `WebSecurityConfigurer` using `hasRole` or `hasAuthority`.

