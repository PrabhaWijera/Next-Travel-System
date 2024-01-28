
localStorage.setItem("PToken",JSON.stringify("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfUEFZTUVOVCIsInN1YiI6InBheTIwMDEiLCJpYXQiOjE2OTgyMTc0NjcsImV4cCI6NDg1MTgxNzQ2N30.d91AdCqnITrzGbsMPvQNr0vYLDtmBocuvcBnep9hC-A"));


// Attach the click event handler to the "payAddButton"
$("#conformedPaymentBTN").on("click", function() {
    alert("badu wada");
    OnSavePayment();
});






function OnSavePayment() {
    // Create an array to store the image data
    const imageArray = [];

    // Define the file input IDs
    const fileInputIds = ["#PayIMG"];

    // Define a function to handle the success of saving an image
    function handleImageSave(data) {
        imageArray.push(data);

        // If all three images have been processed, proceed with saving the data
        if (imageArray.length === fileInputIds.length) {

            const payId="0111";
            // Assuming the first image is for guideID
            const OwnerFullName = $("#OwnerFullName").val();
            const OwnerEmail = $("#OwnerEmail").val();
            const OwnerCardNumber = $("#OwnerCardNumber").val();
            const amountofPackage = $("#amountofPackage").val();
            const date = $("#paymentDate").val();

            const iMGGID = imageArray[0];


            // Create an object to store the data
            const data = {

                payID: payId,
                ownerFullName: OwnerFullName,
                ownerEmail: OwnerEmail,
                ownerCardNumber: OwnerCardNumber,
                paymentAmount: amountofPackage,
                paymentDate: date,
                paymentImageLocation: iMGGID,

            };

            // Retrieve the JWT token from localStorage
            let token = localStorage.getItem("PToken");

            // Check if the token is valid
            if (!token) {
                swal("Token not found. Please log in.");
                return;
            }

            // Make the AJAX request to save the data
            setTimeout(() => {
                $.ajax({
                    url: "http://localhost:8086/api/v1/Payment/PSave",
                    method: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    headers: {
                        "Authorization": "Bearer " + JSON.parse(localStorage.getItem("PToken"))
                    },
                    success: function (response) {
                        swal("res" + response);
                            swal("Save successful");
                            sendEmail();

                        // You can handle the response from the server here if needed
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        swal("Error: " + xhr.responseText);
                    }
                });
            }, 2000);
        }
    }

    // Save each image with a delay
    for (let i = 0; i < fileInputIds.length; i++) {
        const delay = 2000 * i; // Delay increases for each image
        setTimeout(() => {
            saveImage(fileInputIds[i], handleImageSave);
        }, delay);
    }
}


var hcl = "";

function saveImage(fileInputId, successCallback) {
    var formData = new FormData();
    var file = $(fileInputId)[0].files[0];

    if (file) {
        formData.append('imageFile', file);

        $.ajax({
            url: 'http://localhost:8090/api/v1/uploadingUploader/upload',
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                hcl = data;
                console.log("IMG : " + data);
                successCallback(data); // Call the success callback with the image data
            },
            error: function (xhr, textStatus, errorThrown) {
                swal("OOPS!", "Server threw an exception : " + xhr.responseJSON.message, "error");
            }
        });
    } else {
        successCallback(""); // Call the success callback with an empty string if no file selected
    }
}
function sendEmail() {

    const OwnerFullName = $("#OwnerFullName").val();
    const OwnerEmail = $("#OwnerEmail").val();
    const OwnerCardNumber = $("#OwnerCardNumber").val();
    const amountofPackage = $("#amountofPackage").val();
    const date = $("#paymentDate").val();

    console.log(OwnerFullName);
    console.log(OwnerEmail);
    console.log(OwnerCardNumber);
    console.log(amountofPackage);
    console.log(date);

    // Create an object to store the data
    const data = {
        ownerFullName: OwnerFullName,
        ownerEmail: OwnerEmail,
        ownerCardNumber: OwnerCardNumber,
        paymentAmount: amountofPackage,
        paymentDate: date,
    };

    console.log(data);

    $.ajax({
        url: 'http://localhost:8093/api/v1/emails/sendPackageDetails',
        type: 'POST',
        data: JSON.stringify(data), // Convert data to JSON
        contentType: 'application/json', // Set the content type
        headers: {
            Authorization: "Bearer " + JSON.parse(localStorage.getItem("userAuthToken"))
        },
        success: function (response) {
            swal("res" + response);
            swal("Save successful");
            sendEmail();

            // You can handle the response from the server here if needed
        },
        error: function (xhr, textStatus, errorThrown) {
            swal("Error: " + xhr.responseText);
        }
    });
}
