## Objetivo 
Criar API Web que efetua o CRUD (insert,delete,
update e leitura) de três tabelas do banco de dados, sendo duas tabelas geradas a
partir de entidades e uma tabela gerada a partir de um relacionamento ou
agregação.

**Tabelas Selecionadas**
- Pedidos (Orders, gerada por entidade) 
- Itens dos Pedidos (OrderItems, gerada por agregação)
- Produtos (Products, gerada por entidade)

**Tabelas Auxiliares**
- Usuários (User)
- Funcionários (Employees)
- Fornecedores (Suppliers)

**Estrutura do Projeto**

- src/main/java/com/miuau_petshop/MiuAuPetshop
  - MiuAuPetshopApplication.java: inicializa a aplicação spring boot  na porta 8080.
  - /entities: define a estrutura das "tabelas".
  - /Enums: definição de enums
  - /repositories: arquivos responsáveis pelo acesso/queries nas tabelas do banco de dados
  - /services: arquivos que difinem as regras de acesso ao banco de dados/processamento de dados   
  - /dtos: objetos de transferencia de dados que definem a estrutura de alguns dados vindos do client 
  - /controllers: definição das rotas e da lógica de acesso para o client
    
- src/main/resources/application.properties
  - definição das credenciais para conexão com o banco de dados e a porta exposta da api

**Como Usar**
- Requisito: Java 17 ou mais o atual;
- Baixar e descompactar o .zip do projeto ou clonar utilizando  `git clone ssh_url`;
- Caso IntelliJ não seja a IDE utilizada, baixar as dependências com [maven](https://spring.io/guides/gs/maven);
- Baixar o plugin do Lombok na IDE sendo utilizada;
- Criar src/main/resources/application.properties ;
- Configurar a conexão com o banco de dados(relacional) no arquivo application.properties ;
- Executar o arquivo src/main/java/com/miuau_petshop/MiuAuPetshop/MiuAuPetshopApplication.java ;
- Opcional: fazer requisições nas rotas disponíveis nos arquivos definidos na pasta de controllers ;

**Rotas Disponíveis**
- **Observação**: O item de uma compra (OrderItem) é dependente da compra. Por essa razão, as operações de criar, atualizar e deletar são feitas em conjunto (transação) com as da compra no "OrdersService.java".

- **Users**
  - POST:
    - Cria um usuário
    - http://localhost:8080/api/users
    - Body(JSON):
      {
      "cpf":"string",
      "name":"string",
      "lastname":"string",
      "number": 12345678,
      "cep":"string",
      "street":"string",
      "city":"string",
      "state":"string"
      }
  - GET: 
    - Pega uma lista com todos usuários
    - http://localhost:8080/api/users
  - PUT:
    - Atualiza um usuário
    - http://localhost:8080/api/users/id_do_usuario
    - Body(JSON):
      {
      "cpf":"string",
      "name":"string",
      "lastname":"string",
      "number": 12345678,
      "cep":"string",
      "street":"string",
      "city":"string",
      "state":"string"
      }
  - DELETE:
    - Deleta um usuário
    - http://localhost:8080/api/users/id_do_usuario

**Employees**
- POST:
  - Cria um funcionário
  - http://localhost:8080/api/employees
  - Body(JSON):
    {
    "role":"SELLER",
    "userID": 4
    }
- GET:
  - Pega todos os funcionários
  - http://localhost:8080/api/employees
- UPDATE:
  - Atualiza um funcionário
  - http://localhost:8080/api/employees/employee_id
  - Body(JSON):
   {
    "id": 1,
    "role": "SELLER",
    "hired_at": "2024-04-07",
    "user": {
     "id": 4,
     "cpf": "12332537",
     "name": "string",
     "lastname": "string",
     "number": 12345678,
     "cep": "1234567",
     "street": "rua",
     "city": "cidade",
     "state": "estado"
     }
    }
- DELETE:
  - Deleta um funcionário
  - http://localhost:8080/api/employees/emproyee_id

**Suppliers**
- POST:
  - Cria um fornecedor
  - http://localhost:8080/api/suppliers
  - Body(JSON):
    {
    "cnpj":"string",
    "name":"string",
    "number": 12345678,
    "cep":"1234567",
    "street":"rua",
    "city":"cidade",
    "state":"estado"
    }
- GET:
  - Retorna uma lista com os fornecedores existentes
  - http://localhost:8080/api/suppliers

**Products**
- POST:
  - Cria um produto
  - http://localhost:8080/api/products
  - Body(JSON):
    {
    "name":"produto teste 2",
    "price": 20.50,
    "supplierID": 3
    }
- GET:
  - Pega uma lista com os produtos existentes
  - http://localhost:8080/api/products
- UPDATE:
  - Atualiza produto
  - http://localhost:8080/api/products/product_id
  - Body(JSON):
    {
    "name":"novo nome",
    "price": 20.50,
    "supplierID": 3
    } 
- DELETE:
  - Deleta um produto
  - http://localhost:8080/api/products/product_id

**Orders**
- POST:
  - Cria uma compra e itens da compra
  - http://localhost:8080/api/orders
  - Body(JSON):
    {
    "sellerId":1 ,
    "userId": 1 ,
    "commission": 0.5,
    "orderProducts":[
    {
    "productID": 1,
    "quantity": 5
    },
    {
    "productID": 2,
    "quantity": 7
    }
    ]
    }
- GET:
  - Pega uma lista com todas compras registradas
  - http://localhost:8080/api/orders
- UPDATE:
  - Atualiza uma compra e os itens ralacionados a ela
  - http://localhost:8080/api/orders/order_id
  - Body(JSON):
    {
    "sellerId": 1 ,
    "userId": 1 ,
    "commission": 1.0,
    "orderProducts":[
    {
    "productID": 1,
    "quantity": 10
    }]}
- DELETE:
  - Deleta uma compra e os itens relacionados a ela
  - http://localhost:8080/api/orders/order_id

**OrderItems**
- GET:
  - Retorna uma lista de produtos relacionados a uma compra
  - http://localhost:8080/api/order_items
