import React from "react";
import Sidebar from "./Sidebar";
import UploadFilePage from "./UploadFilePage";

function App() {
  return (
    <div className="app-container">
      <Sidebar />
      <div className="main-content">
        <UploadFilePage />
      </div>
    </div>
  );
}

export default App;
