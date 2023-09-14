import React, { useContext } from 'react';
import './job.css';
import { FilterOptionContext } from './Context';

export default function Sidebar() {
  const { filterOption, setFilterOption } = useContext(FilterOptionContext);

  const handleChange = (e, title) => {
    const { name } = e.target;
    setFilterOption({ ...filterOption, [title]: name });
  };


  //hardcoded need to call api
  const getCategories = function () {
    const categories = [
      {
        title: "Work Mode Available",
        arr: ["InOffice", "Remote", "Hybrid"]
      },
      {
        title: "Education Levels",
        arr: ["High School", "Bachelor's Degree", "Master's Degree", "Ph.D."]
      },
      {
        title: "Experience Levels",
        arr: ["Entry Level", "Mid-Level", "Senior Level", "Executive"]
      },
      {
        title: "Industries",
        arr: ["Technology", "Healthcare", "Finance", "Education", "Retail", "Manufacturing"]
      },
      {
        title: "Salary Ranges",
        arr: ["Less than $30,000", "$30,000 - $50,000", "$50,000 - $70,000", "$70,000 - $100,000", "Over $100,000"]
      }
    ];

    return categories;
  }


  const createForm = ({ title, arr }) => {
    return (
      <div className="input-container">
        <div className='input-container-title'>{title}</div>
        <form>
          {arr.map(e =>
            <label key={e}>
              <input
                type="radio"
                name={e}
                onChange={(event) => handleChange(event, title)}
                checked={(filterOption && title) ? filterOption[title] === e : false}
              />
              <span>{e}</span>
            </label>
          )}
        </form>
      </div>
    )
  }

  return (
    <div className='sidebar'>
      {getCategories().map(({ title, arr }) => (
        <div key={title}>
          {createForm({ title, arr })}
        </div>
      ))}
    </div>
  );
}
