document.getElementById('uploadButton').addEventListener('click', function() {
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];
    var preview = document.getElementById('preview');

    if (file) {
        var reader = new FileReader();
        reader.onload = function(e) {
            var img = document.createElement('img');
            img.src = e.target.result;
            preview.appendChild(img);
        };
        reader.readAsDataURL(file);
    } else {
        preview.innerHTML = '请选择一个文件';
    }
});