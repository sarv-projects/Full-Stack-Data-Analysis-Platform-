import React from 'react';
function Sidebar(){
    return(
        <aside className='sidebar'>
            <h2>DataInsight</h2>
            <nav>
                <ul>
                    <li><a href='#'>Upload File</a></li>
                    <li><a href='#'>My Files</a></li>
                    <li><a href='#'>Analytics</a></li>
                    <li><a href='#'>Settings</a></li>
                </ul>
            </nav>
        </aside>
    )
}
export default Sidebar;