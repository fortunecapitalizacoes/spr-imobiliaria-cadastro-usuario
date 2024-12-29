O protocolo do banco do scada exige protocolo TLS10(TLSv1). A partir do java 1.8, por ser considerado inseguro, o mesmo foi desabilitado.
Para conexao, deve-se habilita-lo novamente na jvm usando a linha de comando abaixo:


Aba arguments, vm arguments no eclipse
-Djava.security.properties=sec\security.properties