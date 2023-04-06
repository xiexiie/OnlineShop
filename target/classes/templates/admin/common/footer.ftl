<script type="text/javascript" src="/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="/admin/js/bootstrap.min.js"></script>
<!--对话框-->
<script src="/admin/js/jconfirm/jquery-confirm.min.js"></script>
<script src="/admin/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    //先获取主目录的url,然后按照“/”进行分割，
    //例如： localhost:8081/admin/goods/list,取split[2]时取到的就是 goods,
    //然后再进行一次获取目录，是在子节点的条件下进行获取，然后进行比较，
    //如果相同，就将该目录进行点亮
	var currentUrl = window.location.pathname;
	var curs = currentUrl.split("/");
	currentUrl = curs[2];
	$(".second-menu").each(function(i,e){
		var url = $(e).children("a").attr('href').split("/");
		if(url[2] == currentUrl){
			$(e).addClass('active');
			$(e).parent("ul").parent("li").addClass("active open")
		}
	});
});
</script>
