# Sistema de Locadora de Veículos

Este é um sistema de locadora de veículos que permite o cadastro e gerenciamento de veículos e clientes, além de realizar operações de aluguel e devolução de veículos. O sistema está desenvolvido com base em algumas regras de negócio, que são detalhadas a seguir.

## Funcionalidades

1. **Cadastro de Veículos:** Permite cadastrar novos veículos no sistema, utilizando a placa como identificador único.

2. **Alteração de Veículos:** Permite alterar informações de um veículo já cadastrado.

3. **Busca de Veículos por parte do nome:** Permite buscar veículos por parte do nome para facilitar a localização no sistema.

4. **Cadastro de Clientes:** Permite cadastrar clientes, tanto pessoa física quanto jurídica, utilizando CPF e CNPJ como identificadores únicos, respectivamente.

5. **Alteração de Clientes:** Permite alterar informações de um cliente já cadastrado.

6. **Aluguel de Veículos:** Permite realizar o aluguel de um veículo para clientes, registrando local, data e horário do aluguel.

7. **Devolução de Veículos:** Permite registrar a devolução de um veículo alugado, data e horário da devolução, além de aplicar descontos conforme as regras estabelecidas.

8. **Lista de Veículos**

9. **Lista de Pessoas**


## Regras de Negócio

1. Os veículos não podem ser repetidos, utilizando a placa como identificador de unicidade.
2. Tipos de veículos considerados: PEQUENO, MÉDIO e SUV.
3. Os aluguéis e devoluções devem registrar local, data e horário.
4. Aluguéis em horas quebradas são considerados diárias completas. Exemplo: uma devolução às 15h30 será cobrada uma diária até às 15h30 do dia seguinte.
5. Veículos alugados não estarão disponíveis para locação.
6. Clientes não podem ser duplicados, utilizando CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade.
7. Regras de devolução:
    - Cliente pessoa física com aluguel superior a 5 diárias tem direito a 5% de desconto.
    - Cliente pessoa jurídica com aluguel superior a 3 diárias tem direito a 10% de desconto.

