call gradlew.bat build
copy build\libs\*.jar .
copy *.jar C:\Liferay\liferay-ce-portal-7.2.1-ga2\deploy
del *.jar