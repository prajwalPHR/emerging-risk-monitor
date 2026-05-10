const Navbar = () => {

  const handleLogout = () => {

    localStorage.removeItem("token");

    window.location.href = "/";
  };

  return (

    <div className="bg-gray-900 text-white px-6 py-4 flex justify-between items-center">

      <h1 className="text-2xl font-bold">
        Emerging Risk Monitor
      </h1>

      <button
        onClick={handleLogout}
        className="bg-red-500 hover:bg-red-600 px-4 py-2 rounded"
      >
        Logout
      </button>

    </div>
  );
};

export default Navbar;