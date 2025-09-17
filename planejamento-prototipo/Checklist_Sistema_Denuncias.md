
# ✅ Roadmap de Desenvolvimento – Sistema de Denúncias Anônimas  

### 📌 Semana 1 – Preparação (12/09 – 19/09)  
- [ ] Criar repositório no GitHub  
- [ ] Configurar ambiente local (Java 17+, JDBC, IDE)  
- [ ] Criar estrutura MVC do projeto:  
  - [ ] `src/model`  
  - [ ] `src/dao`  
  - [ ] `src/service`  
  - [ ] `src/controller`  
  - [ ] `src/view`  
- [ ] Configurar banco de dados (MySQL ou PostgreSQL) → `resources/database.sql`  
- [ ] Importar script inicial (`usuarios`, `denuncias`)  
- [ ] Criar protótipo inicial com Swing/JavaFX → `src/view`  

---

### 📌 Semana 2 – Módulo de Denúncia (20/09 – 27/09)  
- [ ] Criar tela de envio de denúncia → `src/view/DenunciaView.java`  
- [ ] Implementar classe `Denuncia` → `src/model/Denuncia.java`  
- [ ] Criar `DenunciaDAO` → `src/dao/DenunciaDAO.java`  
- [ ] Salvar denúncia no banco (sem criptografia ainda)  

---

### 📌 Semana 3 – Segurança I (28/09 – 05/10)  
- [ ] Implementar validação de entrada → `src/service/DenunciaService.java`  
- [ ] Criar utilitário de criptografia AES → `src/model/CriptografiaUtil.java`  
- [ ] Aplicar criptografia antes de salvar denúncia → `src/dao/DenunciaDAO.java`  
- [ ] Testar descriptografia na leitura  

---

### 📌 Semana 4 – Login Seguro (06/10 – 13/10)  
- [ ] Criar tela de login → `src/view/LoginView.java`  
- [ ] Implementar classe `Usuario` → `src/model/Usuario.java`  
- [ ] Criar `UsuarioDAO` → `src/dao/UsuarioDAO.java`  
- [ ] Hash de senha com BCrypt → `src/service/AutenticacaoService.java`  
- [ ] Validar login com senha segura → `src/controller/LoginController.java`  

---

### 📌 Semana 5 – Segurança II (14/10 – 20/10)  
- [ ] Implementar autenticação em dois fatores (via e-mail) → `src/service/AutenticacaoService.java`  
- [ ] Criar controle de permissões (somente admin acessa painel) → `src/controller/AdminController.java`  

---

### 📌 Semana 6 – Painel do Administrador (21/10 – 27/10)  
- [ ] Criar painel de listagem de denúncias → `src/view/AdminView.java`  
- [ ] Exibir denúncias descriptografadas → `src/service/DenunciaService.java`  
- [ ] Implementar alteração de status (pendente, análise, resolvida) → `src/controller/DenunciaController.java`  

---

### 📌 Semana 7 – Finalização Técnica (28/10 – 03/11)  
- [ ] Testar fluxo completo (denúncia → armazenamento → admin)  
- [ ] Revisar camada de segurança → `src/service/`  
- [ ] Implementar testes unitários básicos → `src/test/`  
- [ ] Criar logs de auditoria → `src/service/LogService.java`  

---

### 📌 Semana 8 – Entrega (04/11 – 06/11)  
- [ ] Finalizar relatório acadêmico (ABNT) → `docs/Relatorio.docx`  
- [ ] Finalizar apresentação (PowerPoint/Canva) → `docs/Apresentacao.pptx`  
- [ ] Ensaiar apresentação (12 minutos cronometrados)  

---

# 📊 Banco de Dados – Checklist  
- [ ] Criar tabela `usuarios` com hash de senha (BCrypt) → `resources/database.sql`  
- [ ] Criar tabela `denuncias` com criptografia AES → `resources/database.sql`  
- [ ] (Opcional) Criar tabela `anexos` para upload → `resources/database.sql`  
- [ ] Garantir uso de `PreparedStatement` em todas as queries → `src/dao/`  

---

# 🔒 Segurança – Checklist  
- [ ] Criptografia AES → `src/model/CriptografiaUtil.java`  
- [ ] Hash de senha com BCrypt → `src/service/AutenticacaoService.java`  
- [ ] Autenticação em dois fatores → `src/service/AutenticacaoService.java`  
- [ ] Controle de permissões → `src/controller/`  
- [ ] Validação contra SQL Injection e XSS → `src/service/`  
- [ ] Auditoria e logs → `src/service/LogService.java`  

---

# 🚀 Extras (opcional)  
- [ ] Exportação de denúncias (CSV/PDF) → `src/service/RelatorioService.java`  
- [ ] Notificações por e-mail → `src/service/EmailService.java`  
- [ ] Dashboard com métricas → `src/view/DashboardView.java`  
- [ ] Deploy com Docker → `docker/`  
- [ ] Documentar API com Swagger/OpenAPI → `docs/`  
