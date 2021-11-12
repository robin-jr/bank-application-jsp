var transferVisible=true;
document.addEventListener("DOMContentLoaded", async () => {
   hideTransaction();
});

function hideTransfer(){
    document.getElementById("transfer").hidden=true;
    document.getElementById("transactions").hidden=false;
}
function hideTransaction(){
    document.getElementById("transactions").hidden=true;
    document.getElementById("transfer").hidden=false;
}