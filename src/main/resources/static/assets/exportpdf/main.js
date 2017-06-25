// document.getElementById("btn-html2canvas").onclick = function(){
//
//     // 将 id 为 content 的 div 渲染成 canvas
//     html2canvas(document.getElementById("content"), {
//
//         // 渲染完成时调用，获得 canvas
//         onrendered: function(canvas) {
//
//             // 从 canvas 提取图片数据
//             var imgData = canvas.toDataURL('image/jpeg');
//
//             var doc = new jsPDF("p", "mm", "a4");
//             //                               |
//             // |—————————————————————————————|
//             // A0 841×1189
//             // A1 594×841
//             // A2 420×594
//             // A3 297×420
//             // A4 210×297
//             // A5 148×210
//             // A6 105×148
//             // A7 74×105
//             // A8 52×74
//             // A9 37×52
//             // A10 26×37
//             //     |——|———————————————————————————|
//             //                                 |——|——|
//             //                                 |     |
//             doc.addImage(imgData, 'JPEG', 0, 0,210,297);
//
//             doc.save('content.pdf');
//         }
//     });
//
// }
function exportpdf(){

    // html2canvas(document.getElementById("content"), {
    //     onrendered: function(canvas) {
    //
    //         //通过html2canvas将html渲染成canvas，然后获取图片数据
    //         var imgData = canvas.toDataURL('image/jpeg');
    //
    //         //初始化pdf，设置相应格式
    //         var doc = new jsPDF("p", "mm", "a4");
    //
    //         //这里设置的是a4纸张尺寸
    //         doc.addImage(imgData, 'JPEG', 0, 0,210,297);
    //
    //         //输出保存命名为content的pdf
    //         doc.save('content.pdf');
    //     }
    // });

    html2canvas($("#content"), {
        onrendered: function(canvas) {
            var imgData = canvas.toDataURL('image/jpeg');
            var img = new Image();
            img.src = imgData;
            //根据图片的尺寸设置pdf的规格，要在图片加载成功时执行，之所以要*0.225是因为比例问题
            img.onload = function() {
                //此处需要注意，pdf横置和竖置两个属性，需要根据宽高的比例来调整，不然会出现显示不完全的问题
                if (this.width > this.height) {
                    var doc = new jsPDF('l', 'mm', [this.width * 0.225, this.height * 0.225]);
                } else {
                    var doc = new jsPDF('p', 'mm', [this.width * 0.225, this.height * 0.225]);
                }
                doc.addImage(imgData, 'jpeg', 0, 0, this.width * 0.225, this.height * 0.225);
                //根据下载保存成不同的文件名
                doc.save('report_pdf_' + new Date().getTime() + '.pdf');
            }
        },
        background: "#fff",
        //这里给生成的图片默认背景，不然的话，如果你的html根节点没设置背景的话，会用黑色填充。
        allowTaint: true //避免一些不识别的图片干扰，默认为false，遇到不识别的图片干扰则会停止处理html2canvas
    });
}