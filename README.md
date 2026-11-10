# Atividade SOLID — Sistema de Delivery

Este projeto foi desenvolvido para aplicar os 5 princípios do SOLID em um sistema de delivery com foco em pedidos, pagamentos, produtos, notificações e entregas.

## Objetivo da atividade

A aplicação simula um sistema de restaurante/delivery com as seguintes funcionalidades:

- criar pedido
- salvar pedido
- exibir informações do pedido
- processar pagamentos
- gerar relatórios
- enviar notificações
- gerenciar entregas

A estrutura foi organizada para separar responsabilidades e facilitar a extensão futura do sistema sem quebrar o código existente.

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/com/witortena/solid/
│   │   ├── domain/
│   │   │   ├── Product.java
│   │   │   ├── Pizza.java
│   │   │   ├── Hamburguer.java
│   │   │   └── Bebida.java
│   │   ├── interfaces/
│   │   │   ├── NotificationChannel.java
│   │   │   ├── ReportGenerator.java
│   │   │   ├── OrderManager.java
│   │   │   └── DeliveryManager.java
│   │   ├── notification/
│   │   │   ├── NotificationService.java
│   │   │   ├── EmailNotificationChannel.java
│   │   │   ├── SmsNotificationChannel.java
│   │   │   └── WhatsAppNotificationChannel.java
│   │   ├── order/
│   │   │   ├── Order.java
│   │   │   ├── OrderCreator.java
│   │   │   ├── OrderSaver.java
│   │   │   ├── OrderRepository.java
│   │   │   ├── InMemoryOrderRepository.java
│   │   │   └── OrderDisplay.java
│   │   ├── payment/
│   │   │   ├── PaymentMethod.java
│   │   │   ├── CardPayment.java
│   │   │   ├── PixPayment.java
│   │   │   ├── CashPayment.java
│   │   │   └── PaymentProcessor.java
│   │   ├── service/
│   │   │   ├── RestaurantOrderManager.java
│   │   │   ├── SalesReportGenerator.java
│   │   │   └── DeliveryCoordinator.java
│   │   └── SolidApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/witortena/solid/
        └── SolidPrinciplesTest.java
```

## Princípios SOLID aplicados

### 1) SRP — Single Responsibility Principle

A responsabilidade de cada classe foi separada de maneira clara:

- `OrderCreator`: cria o pedido
- `OrderSaver`: salva o pedido
- `OrderDisplay`: exibe as informações do pedido
- `OrderRepository`: abstrai a persistência
- `InMemoryOrderRepository`: implementação em memória

Isso evita que uma única classe fique responsável por criar, salvar e exibir tudo ao mesmo tempo.

### 2) OCP — Open/Closed Principle

A aplicação usa a interface `PaymentMethod` para representar diferentes formas de pagamento.

Implementações existentes:

- `CardPayment`
- `PixPayment`
- `CashPayment`

A lógica principal do sistema não precisa mudar para adicionar um novo tipo de pagamento. Basta criar uma nova classe que implemente `PaymentMethod`.

### 3) LSP — Liskov Substitution Principle

A classe base `Product` define comportamento comum para todos os produtos.

Subclasses:

- `Pizza`
- `Hamburguer`
- `Bebida`

Todos esses tipos podem ser usados no lugar da classe base sem causar comportamento incorreto. Cada produto respeita o contrato de `Product` e fornece `getType()` e `getDescription()` corretamente.

### 4) ISP — Interface Segregation Principle

Foram criadas interfaces específicas para cada responsabilidade:

- `NotificationChannel`: envio de notificações
- `ReportGenerator`: geração de relatórios
- `OrderManager`: gerenciamento de pedidos
- `DeliveryManager`: gerenciamento de entregas

Assim, uma classe não precisa implementar métodos que não usa.

### 5) DIP — Dependency Inversion Principle

A classe `NotificationService` não depende diretamente de classes concretas, e sim de abstrações.

Exemplo:

- `NotificationService` depende de `NotificationChannel`
- `EmailNotificationChannel`, `SmsNotificationChannel` e `WhatsAppNotificationChannel` implementam essa interface

Com isso, o serviço de notificação fica desacoplado e pode trocar o canal sem alterar a lógica principal.

## Principais classes e responsabilidades

### Produtos

- `Product`: base abstrata para todos os itens do cardápio
- `Pizza`: produto do tipo pizza
- `Hamburguer`: produto do tipo hambúrguer
- `Bebida`: produto do tipo bebida

### Pedidos

- `Order`: representa um pedido com itens, status e valor total
- `OrderCreator`: cria pedidos
- `OrderSaver`: salva pedidos no repositório
- `OrderDisplay`: retorna uma representação legível do pedido

### Pagamentos

- `PaymentMethod`: contrato para qualquer meio de pagamento
- `CardPayment`: pagamento com cartão
- `PixPayment`: pagamento com PIX
- `CashPayment`: pagamento em dinheiro
- `PaymentProcessor`: aplica o cálculo do valor final conforme o método escolhido

### Notificações

- `NotificationChannel`: interface para canais de notificação
- `EmailNotificationChannel`
- `SmsNotificationChannel`
- `WhatsAppNotificationChannel`
- `NotificationService`: envia as mensagens usando o canal configurado

### Relatórios e entregas

- `SalesReportGenerator`: gera relatório de vendas
- `DeliveryCoordinator`: simula a gestão de entregas

## Como executar

### Requisitos

- Java 21+
- Maven

### Rodar a aplicação

```bash
cd springboot/solid/solid
./mvnw spring-boot:run
```

### Rodar os testes

```bash
cd springboot/solid/solid
./mvnw test
```

## Testes incluídos

O projeto possui testes automatizados para verificar:

- criação de pedido
- cálculo do valor total
- suporte a diferentes formas de pagamento
- uso correto das subclasses de produto
- envio de notificação
- geração de relatório
- exibição do pedido

Os testes estão em:

- [src/test/java/com/witortena/solid/SolidPrinciplesTest.java](src/test/java/com/witortena/solid/SolidPrinciplesTest.java)

## Conclusão

O projeto demonstra de forma prática como estruturar um sistema seguindo os princípios do SOLID, mantendo o código mais organizado, extensível e fácil de manter.

É uma base útil para atividades acadêmicas, exercícios de aula e projetos que precisam aplicar boas práticas de arquitetura de software.
