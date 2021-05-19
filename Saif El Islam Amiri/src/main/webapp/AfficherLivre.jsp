<%@page import="model.Etudiant"%>
<%@page import="model.Livre"%>
<%@page import="DAO.LivreManager"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CategorieManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%
HttpSession ss = request.getSession(false);
if(ss.getAttribute("etudiant") != null){
	Etudiant e = (Etudiant)ss.getAttribute("etudiant");
	%>
	<p>Bonjour <%=e.getNom() +" "+e.getPrenom() %></p>
	<%
}
CategorieManager m = new CategorieManager();
LivreManager ml = new LivreManager();
List<Livre> vl = ml.AllLivres();
List<Categorie> cl = m.AllCategories();
if(request.getParameter("categ") != null){
	vl = ml.livresParCategorie(Integer.parseInt(request.getParameter("categ")));
}
%>

<div class="container">
  <h2>Afficher Livre</h2>
  
  <form action="" class="was-validated">
             <div class="form-group">
      <label for="categ">Categorie :</label>
			<select class="form-control" id="uname" name="categ" required >
			<%
			for(Categorie c : cl){
			%>
			<option value=<%=c.getId() %>><%= c.getCat_name() %></option>
			<%} %>
			</select>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  <div class="container">
  <h2></h2>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>Titre</th>
        <th>Auteur</th>
        <th>categorie</th>
      </tr>
    </thead>
    <tbody>
    <%
    for(Livre v: vl){
    %>
      <tr>
        <td><%=v.getNom_livre() %></td>
        <td><%= v.getAuteur() %></td>
        <td><%= v.getC().getCat_name() %></td>
      </tr>
      <%} %>
    </tbody>
  </table>
</div>
  
</div>
</body>
</html>