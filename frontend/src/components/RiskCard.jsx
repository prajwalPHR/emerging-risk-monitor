const RiskCard = ({ risk }) => {

  return (

    <div className="bg-white shadow-lg rounded-lg p-5">

      <h2 className="text-xl font-bold mb-2">
        {risk.title}
      </h2>

      <p className="text-gray-600 mb-4">
        {risk.status}
      </p>

      <span className="bg-blue-100 text-blue-700 px-3 py-1 rounded">
        Risk Item
      </span>

    </div>
  );
};

export default RiskCard;