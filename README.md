# quarkus-reproduce-err-timeout

Sample project to reproduce issue https://github.com/quarkusio/quarkus/issues/23360

## reproduce with curl

On linux ubuntu mint: (curl uses HTTP/2 200)

If we send a correct user and password:

``` 
curl -i --insecure -X POST https://localhost:8180/j_security_check --max-time 2 -H "Content-Type: application/x-www-form-urlencoded"  -d "j_username=admin&j_password=admin"
```

it should returns:
``` 
HTTP/2 200 
content-length: 0
set-cookie: quarkus-credential=DPLF9TfeDhesLyIwm6IB4Jk6URgArUAgnI2einzkM8fP1QHLJ4SmsBe2tfSrtdM9; Path=/; Secure; SameSite=Strict
``` 

But it will returns timeout if you don't use a correct user and password:

``` 
curl -i --insecure -v -X POST https://localhost:8180/j_security_check --max-time 2 - -H "Content-Type: application/x-www-form-urlencoded"  -d "j_username=aaaa&j_password=bbb"
```

## reproduce with browser

Go to https://localhost:8180/

Open debugger and go to network

Click on "LoginOk"  => see status 200

Click on "LoginErr" => see the exception in quarkus and time out in the broswer.




