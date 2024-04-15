function getCookie(cname){
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) 
  {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}
function formatter(time){
  var d = new Date(parseInt(time));
  return d.toLocaleString();
}
async function postData(url = "", data = {}){
  const response = await fetch(url, {
    method: "POST",
    headers:{
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  return response.json();
}