import { useState } from "react";

import API from "../api/axios";

const AddRisk = ({ fetchRisks }) => {

  const [title, setTitle] = useState("");

  const [status, setStatus] = useState("");

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      await API.post("/risks", {
        title,
        status,
      });

      setTitle("");
      setStatus("");

      fetchRisks();

    } catch (err) {

      console.log(err);
    }
  };

  return (

    <div className="bg-white shadow-lg rounded-lg p-6 mb-6">

      <h2 className="text-2xl font-bold mb-4">
        Add Risk
      </h2>

      <form onSubmit={handleSubmit}>

        <div className="mb-4">

          <label className="block mb-2">
            Risk Title
          </label>

          <input
            type="text"
            placeholder="Enter title"
            className="w-full border px-3 py-2 rounded"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />

        </div>

        <div className="mb-4">

          <label className="block mb-2">
            Status
          </label>

          <input
            type="text"
            placeholder="Open / Closed"
            className="w-full border px-3 py-2 rounded"
            value={status}
            onChange={(e) => setStatus(e.target.value)}
          />

        </div>

        <button
          type="submit"
          className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded"
        >
          Add Risk
        </button>

      </form>

    </div>
  );
};

export default AddRisk;