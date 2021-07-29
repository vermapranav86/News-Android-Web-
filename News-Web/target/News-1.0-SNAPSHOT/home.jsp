<%@page import="PKGJava.NewsData"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <%ArrayList<NewsData> list = (ArrayList<NewsData>) session.getAttribute("DataArray");%>
    

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome Page</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="welcome.css">
  <link rel="stylesheet" href="style.css" type="text/css"/>

  <script src="https://cdn.jsdelivr.net/gh/ethereum/web3.js@1.0.0-beta.36/dist/web3.min.js" integrity="sha256-nWBTbvxhJgjslRyuAKJHK+XcZPlCnmIAAMixz6EefVk=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">NEWS APP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="APIcall">All </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="APIcall?type=ent">Entertainments</a>
        </li>
       
        <li class="nav-item">
          <a class="nav-link " href="APIcall?type=sport">Sports</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="APIcall?type=tech">Technology</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="APIcall?type=poli">Business</a>
        </li>
      </ul>
     
    </div>
  </nav>
 
  <div class="row" style="margin-left: 10%; margin-right: 10%;">
     <%for(int i=0;i<list.size();i++){%> 
    <div class="col-lg-6 justify-content-around">
        <!-- Blog post-->
        <div class="card mb-4">
            <a href="#!"><img class="card-img-top"  src="<%=list.get(i).urlToImage%>" alt="..." /></a>
            <div class="card-body">
                <div class="small text-muted"><%=list.get(i).date%></div>
                <h2 class="card-title h4"><%=list.get(i).title%></h2>
                <p class="card-text"><%=list.get(i).autor%></p>
                <a class="btn btn-primary" href="<%=list.get(i).url%>" target="_blank" >Read more</a>
                <%i++;%>
            </div>
        </div>
        <!-- Blog post-->
         <div class="card mb-4">
            <a href="#!"><img class="card-img-top"  src="<%=list.get(i).urlToImage%>" alt="..." /></a>
            <div class="card-body">
                
                <div class="small text-muted"><%=list.get(i).date%></div>
                <h2 class="card-title h4"><%=list.get(i).title%></h2>
                <p class="card-text"><%=list.get(i).autor%></p>
                <a class="btn btn-primary" href="<%=list.get(i).url%>" target="_blank">Read more</a>
             
            </div>
        </div>
    </div>
            <% } %>
 
    
   
</div>
 
  
  
 
</body>
</html>