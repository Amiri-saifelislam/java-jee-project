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
</head>
<body>
<%
CategorieManager m = new CategorieManager();
List<Categorie> l = m.AllCategories();
%>
<div class="container">
  <h2>Ajouter Categorie</h2>
  
  <form action="AjouterCategorie" class="was-validated">
    <div class="form-group">
      <label for="categ">Categorie :</label>
      <input type="text" class="form-control" id="uname" placeholder="Entrer la categorie" name="categ" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
 </div>
<div class="container">
  <h2>Ajouter Livre</h2>
  
  <form action="AjouterLivre" class="was-validated">
    <div class="form-group">
      <label for="titre">Titre :</label>
      <input type="text" class="form-control" id="uname" placeholder="Entrer le titre" name="titre" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
       <div class="form-group">
      <label for="auteur">Auteur :</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter le nom de l'auteur" name="auteur" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
       <div class="form-group">
      <label for="categ">Categorie :</label>
			<select class="form-control" id="uname" name="categ" required >
			<%
			for(Categorie c : l){
			%>
			<option value=<%=c.getId() %>><%= c.getCat_name() %></option>
			<%} %>
			</select>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
   
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
</html>