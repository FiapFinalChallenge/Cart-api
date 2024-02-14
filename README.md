
# Cart API

## Descrição

A Cart API é responsável por gerenciar as operações do carrinho de compras no sistema de e-commerce. Ela permite aos usuários adicionar, remover e listar itens no carrinho de compras, integrando-se com outros serviços como o serviço de itens (Items Service), o serviço de autenticação (Authentication Service), e o Eureka Server para descoberta de serviços.

## Pré-requisitos

- Docker
- Docker Compose

## Iniciando a API

Para iniciar a API de Cart junto com os serviços dependentes, siga os passos abaixo:

1. **Clone o Repositório (se aplicável)**
   Certifique-se de ter o código fonte localmente. Se necessário, clone o repositório usando:

   \`\`\`bash
   git clone <url-do-repositorio>
   \`\`\`

2. **Navegue até o Diretório do Projeto**
   Altere para o diretório que contém o arquivo `docker-compose.yml`:

   \`\`\`bash
   cd <caminho-para-o-diretorio>
   \`\`\`

3. **Inicie os Serviços com Docker Compose**
   Execute o seguinte comando para iniciar todos os serviços definidos no `docker-compose.yml`, incluindo a Cart API:

   \`\`\`bash
   docker-compose up -d
   \`\`\`

   Este comando construirá as imagens necessárias (se ainda não estiverem construídas) e iniciará os contêineres em modo desanexado.

## Serviços Iniciados

Ao executar o comando acima, os seguintes serviços serão iniciados:

- **MySQL Database**: Banco de dados utilizado pelos serviços.
- **Eureka Server**: Serviço de descoberta que permite que os microserviços se encontrem e comuniquem.
- **Spring Cloud Config Server**: Serviço de configuração centralizada para os microserviços.
- **Authentication Service**: Serviço de autenticação para o sistema de e-commerce.
- **Items Service**: Serviço de gerenciamento de itens do inventário.
- **Cart API**: A própria API de carrinho de compras que você está iniciando.

## Acessando a API

Após o início, a Cart API estará disponível em:

\`\`\`
http://localhost:8083/
\`\`\`

Você pode interagir com a API usando ferramentas como cURL, Postman ou qualquer cliente HTTP de sua escolha.
