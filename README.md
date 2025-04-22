```shell
keytool -genkey -alias wiremock -keyalg RSA -validity 36500 -keystore src/main/resources/wiremock.p12 -storetype PKCS12 -storepass password -keypass password -dname "CN=localhost, OU=ID, O=Unknown, L=Unknown, S=Unknown, C=Unknown"
```
