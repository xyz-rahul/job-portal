import React, { useContext, useEffect, useState } from 'react'
import './sideBarPanel.css'
import { FilterOptionContext } from './Context'
import { BASE_URL } from '../api/apiUtils';
import axios from 'axios';
export default function SideBarPanel() {
    const { filterOption, setFilterOption } = useContext(FilterOptionContext);
    const [filterArr, setFilterArr] = useState([]);


    useEffect(() => {
        // Fetch filter categories from the API when the component mounts
        const fetchFilterCategories = async () => {
            try {
                const response = await axios.get(`${BASE_URL}/jobs/getJobFilterOptions`);
                const data = response.data;
                setFilterArr(Object.values(data));
            } catch (error) {
                // Handle the error here
                console.error('Error fetching filter options:', error);
            }
        };

        fetchFilterCategories();
    }, []);




    const handleFormChages = (e) => {
        const { title, value, checked } = e.target;

        // Make a copy of the current filterOption object
        const updatedFilterOption = { ...filterOption };

        // If the title is not already a key in the filterOption object, create an empty array
        if (!(title in updatedFilterOption)) {
            updatedFilterOption[title] = [];
        }

        if (checked) {
            // Checkbox is checked, add the value if it's not already in the array
            if (!updatedFilterOption[title].includes(value)) {
                updatedFilterOption[title].push(value);
            }
        } else {
            // Checkbox is unchecked, remove the value from the array if it exists
            const index = updatedFilterOption[title].indexOf(value);
            if (index !== -1) {
                updatedFilterOption[title].splice(index, 1);
            }
        }

        // Update the filterOption state with the updated object
        setFilterOption(updatedFilterOption);
    };

    const optionContainer = (obj) => {
        const { title, values } = obj;

        return (
            <div className="option-container" key={title}>
                    <div className="container-title">{title}</div>
                <form onChange={handleFormChages} >
                    {values.map((e) => (

                        <label key={e} className="checkbox-container" >
                            <input
                                title={title}
                                className="custom-checkbox"
                                type="checkbox"
                                value={e}
                            />
                            <span className="checkmark"></span>
                            <div className='checkbox-label'>{e}</div>
                        </label>

                    ))}
                </form>
            </div>
        );
    };



    return (
        <div className='sideBarPanel'>
            {filterArr && filterArr.map((arr) => optionContainer(arr))}
        </div>
    )
}
