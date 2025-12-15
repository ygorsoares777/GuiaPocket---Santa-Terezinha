# 📱 Guia Pocket - Santa Terezinha

## 📋 Parte 2 Sobre o Projeto
O **Guia Pocket – Santa Terezinha** é um aplicativo Android desenvolvido em **Kotlin** que funciona como um **guia comercial local**, permitindo cadastrar, visualizar, pesquisar e acessar informações detalhadas de estabelecimentos do bairro Santa Terezinha, em Américo Brasiliense/SP.

Nesta **nova versão do projeto**, o aplicativo evoluiu de uma lista estática para um sistema **dinâmico**, com **persistência de dados local**, **cadastro de novos comércios**, **filtro em tempo real** e uso de **boas práticas modernas do Android**.

## 🆕 Novidades do Projeto Atual

- 🗄️ **Persistência de dados com Room Database**
- ➕ **Cadastro de novos estabelecimentos pelo usuário**
- 🖼️ **Seleção de imagem da galeria usando Activity Result**
- 🔍 **Filtro em tempo real por nome e categoria**
- ♻️ **RecyclerView com Adapter personalizado**
- 🔁 **Atualização automática da lista ao retornar para a tela principal**

---

## 🎥 Demonstração em Vídeo

🎬 Vídeo demonstrando:
- Cadastro de um novo comércio
- Listagem automática
- Filtro em tempo real
- Tela de detalhes
- Ligações e navegação pelo Google Maps



https://github.com/user-attachments/assets/3954573a-0827-4c4b-8408-1ead8b493d74



---

## ✨ Funcionalidades

- 📋 **Listagem de Estabelecimentos**
  - Exibição em **RecyclerView**
  - Nome, categoria e imagem
  - Atualização automática dos dados

- ➕ **Cadastro de Comércios**
  - Inserção de dados pelo usuário
  - Seleção de imagem da galeria
  - Salvamento local no banco de dados

- 🔍 **Filtro em Tempo Real**
  - Pesquisa por nome ou categoria
  - Atualização instantânea da lista

- 📄 **Tela de Detalhes**
  - Informações completas do comércio
  - Imagem, descrição e contatos

- 📞 **Intents Nativas**
  - Ligar para o estabelecimento
  - Abrir endereço no Google Maps
 
  ## 🛠 Tecnologias Utilizadas

- **Linguagem:** Kotlin  
- **Arquitetura:** Activities  
- **Persistência:** Room Database  
- **Concorrência:** Coroutines + lifecycleScope  
- **UI:** XML + ViewBinding  
- **Listagem:** RecyclerView + Adapter personalizado  
- **APIs Android:**
  - Intents explícitas e implícitas
  - Activity Result API  

## 📋 Sobre o Projeto parte 1

O **Guia Pocket - Santa Terezinha** é um aplicativo Android desenvolvido em Kotlin que funciona como um guia comercial completo para o bairro Santa Terezinha, em Américo Brasiliense/SP.

O aplicativo permite aos usuários explorar estabelecimentos locais, visualizar informações detalhadas e utilizar funcionalidades nativas do dispositivo como **ligações telefônicas e navegação via Google Maps**.

## 📸 Capturas de Tela

### 🌞 Modo Claro (  Português | Inglês  )

<img width="300" height="500" alt="tema claro" src="https://github.com/user-attachments/assets/ecfd1f61-1b3b-48b1-ba40-ce4b5a44cfe0" />

<img width="300" height="500" alt="tema claro ing" src="https://github.com/user-attachments/assets/95297aa4-e5e1-4942-b23e-6ba8ce5c6072" />



### 🌙 Modo Escuro (  Português | Inglês  )

<img width="300" height="500" alt="tema escuro pt" src="https://github.com/user-attachments/assets/21c4b0c1-2ffa-444f-80a9-ec07ed9ec07f" />

<img width="300" height="500" alt="tema escuro ing" src="https://github.com/user-attachments/assets/c907dd5a-06a8-473e-871c-5a0fa2b35e19" />

## 🎥 Demonstração em Vídeo



https://github.com/user-attachments/assets/28ab8c3b-c00b-4f76-b792-261e59f0ec60





## ✨ Funcionalidades

- 📋 **Lista de Estabelecimentos** - Visualização em lista com imagens e categorias
- 🔍 **Detalhes Completos** - Informações detalhadas de cada comércio
- 📞 **Intents Nativas** - Ligar, abrir no Maps .
- 🌐 **Internacionalização** - Suporte a Português e Inglês
- 🎨 **Modo Claro/Escuro** - Alternância automática
- 📱 **Interface Responsiva** - Design Material Design 3

## 🛠 Tecnologias

- **Linguagem:** Kotlin
- **UI:** XML com ViewBinding
- **Design:** Material Design 3
- **Componentes:** ListView, Adapter Personalizado, Intents
- **Recursos:** Internacionalização, Temas Claro/Escuro

## 🏢 Estabelecimentos

### 🛒 Comércios
- 🏢 **Alves** 
- ✏️ **AMaluca** 
- 🔧 **KobAuto**

### 🍔 Alimentação & Bebidas
- 🍻 **Sempre On** 
- 🍧 **Quintal do Açai**
- 🥩 **Ponto do Churrasco**

## 🎯 Telas do App

### 🏠 Tela Principal (MainActivity)
- Lista rolável de estabelecimentos
- Exibição de imagem, nome e categoria
- Tema e idioma automáticos
- Design responsivo

### 📍 Tela de Detalhes (DetalheActivity)
- Imagem em destaque
- Informações completas do estabelecimento
- Botões de ação:
  - 📞 **Ligar**
  - 🗺️ **Abrir no Maps**
  - 🔙 **Voltar**

## 🚀 Como Executar

1. Obtenha o projeto:
   
- Baixe o repositório do GitHub — você pode fazer isso clonando com o comando abaixo ou baixando o arquivo .zip e extraindo em seu computador:

  git clone https://github.com/ygorsoares777/GuiaPocket---Santa-Terezinha.git


2. Abra no Android Studio:
   
- Inicie o Android Studio, selecione “Open Project” e escolha a pasta onde o projeto foi salvo.

4. Sincronize as dependências:
   
- Assim que o projeto for aberto, o Android Studio solicitará a sincronização com o Gradle.
Clique em “Sync Now” para garantir que todas as bibliotecas sejam configuradas corretamente.

6. Execute o app:
   
- Escolha um emulador Android ou conecte um dispositivo físico via USB, e clique em Run ▶️ para visualizar o aplicativo em funcionamento.

## 📖 Autor

 O Projeto foi desenvolvido por Ygor Soares💻

