# app-role-auth
app-role-auth / Role-Based Access Control - RBAC

📌 Regras de Negócio (RB)

# Regras de Permissões (Permission)
<p>RB-11 - Uma permissão deve ter um nome único no sistema. ( ✅ )</p>
✅ Exemplo: "READ_USER" e "READ_USER" não podem coexistir.
<p>RB-12 - Uma permissão pode estar vinculada a múltiplos papéis. (  )</p>
✅ Permissões podem ser reutilizadas entre papéis.
<p>RB-13 - Permissões podem ser criadas apenas por um administrador. (  )</p>
✅ Somente administradores podem gerenciar permissões.
<p>RB-14 - Permissões podem ser revogadas de um papel a qualquer momento, exceto se isso 
remover acesso administrativo essencial. (  )</p>
✅ Exemplo: Se um administrador perder permissões essenciais, o sistema pode bloquear essa ação.