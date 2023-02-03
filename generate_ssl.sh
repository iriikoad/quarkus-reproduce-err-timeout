
keytool -genkeypair -storepass changeit -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore ./config/server.keystore

cp ./config/server.keystore ./config/server.truststore


