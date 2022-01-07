/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `control_usuarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
                            `id` bigint(20) NOT NULL,
                            `nombre` varchar(40) COLLATE utf8_bin NOT NULL,
                            `ap_paterno` varchar(40) COLLATE utf8_bin NOT NULL,
                            `ap_materno` varchar(40) COLLATE utf8_bin NOT NULL,
                            `email` varchar(255) COLLATE utf8_bin NOT NULL,
                            `telefono` varchar(40) COLLATE utf8_bin NOT NULL,
                            `password` varchar(512) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `ap_paterno`, `ap_materno`, `email`, `telefono`, `password`) VALUES
                                                                                                         (1, 'Rafael', 'Osnaya', 'de Lucio', 'osnayadeluciorafael@hotmail.com', '5560181856', '3312'),
                                                                                                         (2, 'Rafael', 'Osnaya', 'de Lucio', 'osnayadeluciorafael@hotmail.com', '5560181856', '3312'),
                                                                                                         (5, 'Rafael', 'Osnaya', 'de Lucio', 'osnayadeluciorafael@hotmail.com', '5560181856', '3312'),
                                                                                                         (6, 'Rafael', 'Osnaya', 'de Lucio', 'osnayadeluciorafael@hotmail.com', '5560181856', '3312'),
                                                                                                         (11, 'rafael', 'osnaya', 'de lucio', 'osnata@mail.com', '345354345345', '123456'),
                                                                                                         (12, 'rafael', 'osnaya', 'de lucio', 'osnaya@mail.com', '5560181856', '$argon2id$v=19$m=1024,t=1,p=1$0TVSR372wSLWcNnFvAfkcQ$EgD9Hhi9V3INkJG8dsWheW9Z/QBQxLXkPs1zGyhrc4g');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
