import React, { useState } from "react";

function UploadFilePage() {
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleUpload = async(event) => {
    event.preventDefault();
    if (selectedFile) {
      const formData=new FormData();
      formData.append("file",selectedFile);
      console.log("Selected file:", selectedFile.name);
      try{
        const response=await fetch("http://localhost:8080/api/files/upload",{method:"POST",body:formData});
        if(response.ok){
          const result=await response.text();
          console.log("File uploaded successfully!!");
        }
        else{
          console.log("Upload failed!!");
          alert("File upload failed!!");
        }
      }
      catch(error)
      {
        console.error("Error during upload:",error);
        alert("An error occurred during uplaod .Please try again!!");
      }
    } else {
      alert("Please select a file first!!");
    }
  };

  return (
    <div className="upload-container">
      <h2>Upload a CSV File</h2>
      <p>Select a CSV file from your computer to begin the analysis</p>
      <form className="upload-form" onSubmit={handleUpload}>
        <input type="file" accept=".csv" onChange={handleFileChange} />
        <button type="submit">Upload</button>
      </form>
    </div>
  );
}

export default UploadFilePage;
