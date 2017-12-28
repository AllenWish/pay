//新窗口打开
function open_win(s) {
		window.open(s)
}
//返回
function back() {
	window.history.back();
}
function getData(id){
    var $fo = $('#'+id+'Form')
    $.ajax({
        type:"POST",
        url:$fo.attr('action'),
        data:$fo.serialize(),
        success:function(data) {
            if(data.flag){
                var $tbody = $('#'+id+'Data').find('tbody')
                $tbody.empty();
                var $th = $("table tr th");
                $.each(data.data,function(index,item){
                    var $tr = $("<tr></tr>"),$hd = $("<td class='hide'></td>"),$td=$("<td></td>")
                        ,$optDiv=$("<div class=\"btn-group btn-group-xs\" role=\"group\" ></div>");

                    $.each($th,function(index,itm){
                        var name = $(itm).attr('name');
                        if(name!='opt') {
                            if($(itm).hasClass('hide')||$(itm).hasClass('.hide')){
                                $tr.append($hd.clone().text(item[name]));
                            }else{
                                $tr.append($td.clone().text(item[name]));
                            }
                        }else{
                            $tr.append($td.clone().html($optDiv.clone().html("<button type=\"button\" class=\"btn btn-danger\" onclick=\"delete"+id+"("+item.id+")\">删除</button>"
                            )));
                        }
                    });

                    $tr.appendTo($tbody);
                });
            }else{
                alert(data.msg);
            }
        },
        dataType :"json",
        error:function(e){
            console.info(e)
        }
    });
}

function resetForm(id) {
    $(':input','#'+id+'Form')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
    getData(id)
}