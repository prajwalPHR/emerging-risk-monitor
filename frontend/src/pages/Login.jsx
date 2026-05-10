import { useEffect, useState } from "react";

import API from "../api/axios";

import Navbar from "../components/Navbar";
import Loader from "../components/Loader";
import RiskCard from "../components/RiskCard";
import AddRisk from "../components/AddRisk";

const Dashboard = () => {

  const [risks, setRisks] = useState([]);

  const [loading, setLoading] = useState(true);

  const [error, setError] = useState("");

  useEffect(() => {

    fetchRisks();

  }, []);

  const fetchRisks = async () => {

    try {

      const response = await API.get("/risks");

      setRisks(response.data);

    } catch (err) {

      setError("Failed to fetch risks");

    } finally {

      setLoading(false);
    }
  };

  if (loading) {

    return <Loader />;
  }

  return (

    <div className="min-h-screen bg-gray-100">

      <Navbar />

      <div className="p-6">

        <AddRisk fetchRisks={fetchRisks} />

        <h1 className="text-3xl font-bold mb-6">
          Risk Dashboard
        </h1>

        {error && (

          <p className="text-red-500 mb-4">
            {error}
          </p>
        )}

        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">

          {risks.map((risk) => (

            <RiskCard
              key={risk.id}
              risk={risk}
            />
          ))}

        </div>

      </div>

    </div>
  );
};

export default Dashboard;