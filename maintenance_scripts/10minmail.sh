#!/usr/bin/env bash

#wget 'https://www.10minutesmail.fr/' \
#-H 'Host: www.10minutesmail.fr' \
#-H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0'\
#-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' \
#-H 'Accept-Language: en-US,en;q=0.5' \
#-H 'Accept-Encoding: gzip, deflate, br' \
#-H 'Referer: https://www.google.ru/' \
#-H 'Cookie: _ga=GA1.2.667207756.1516217825; _gid=GA1.2.639166498.1516393403; 10MinutMailCOUK2=icmgssodbviin4rr12ct3jvho0; emailInfo=394893%3Bd81263544ea293a5adf4d2c2f9bc2a54a81622e6' \
#-H 'Connection: keep-alive'  \
#-H 'Upgrade-Insecure-Requests: 1' \
#-H 'Cache-Control: max-age=0'



#wget -v 'http://tempinbox.com/Home/ValidateUser' \
#-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' \
#-H 'Accept-Encoding: gzip, deflate' \
#-H 'Accept-Language: en-US,en;q=0.5' \
#-H 'Connection: keep-alive' \
#-H 'Cookie: ASP.NET_SessionId=zcdxwt3u1hy1dmt54gc14121' \
#-H 'Host: tempinbox.com' \
#-H 'Referer: http://tempinbox.com/' \
#-H 'Upgrade-Insecure-Requests: 1' \
#-H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0' \
#-H 'Content-Type: application/x-www-form-urlencoded' -X POST --data 'userInput=e5bretrhytry&terms=true'
#
#
#wget -v 'http://tempinbox.com/Home/CheckEmail' \
#-H 'Host: tempinbox.com' \
#-H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0' \
#-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' \
#-H 'Accept-Language: en-US,en;q=0.5' \
#-H 'Accept-Encoding: gzip, deflate' \
#-H 'Referer: http://tempinbox.com/' \
#-H 'Cookie: ASP.NET_SessionId=zcdxwt3u1hy1dmt54gc14121' \
#-H 'Connection: keep-alive' \
#-H 'Upgrade-Insecure-Requests: 1'
#
#curl 'http://tempinbox.com/Home/CheckEmail' \
#-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' \
#-H 'Accept-Encoding: gzip, deflate' \
#-H 'Accept-Language: en-US,en;q=0.5' \
#-H 'Connection: keep-alive' \
#-H 'Cookie: ASP.NET_SessionId=zcdxwt3u1hy1dmt54gc14121' \
#-H 'Host: tempinbox.com' \
#-H 'Upgrade-Insecure-Requests: 1' \
#-H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0'


curl 'http://tempinbox.com/Home/CheckEmail' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Accept-Language: en-US,en;q=0.9' \
-H 'Upgrade-Insecure-Requests: 1' \
-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8' \
-H 'Connection: keep-alive' --compressed \
-H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36' \
-H 'Cache-Control: max-age=0' \
-H 'Cookie: ASP.NET_SessionId=dsaosg4bmgpuxhnax1qp1ub2' \
