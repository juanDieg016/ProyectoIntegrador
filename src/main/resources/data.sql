TRUNCATE TABLE news RESTART IDENTITY CASCADE;
TRUNCATE TABLE testimonials RESTART IDENTITY CASCADE;
TRUNCATE TABLE contact_requests RESTART IDENTITY CASCADE;

INSERT INTO news (
    title,
    summary,
    content,
    image_url,
    author,
    publication_date,
    state
)
VALUES (

'Cimientos de esperanza en Ecuador',

'Proyecto social enfocado en educación y desarrollo comunitario.',

'Ecuador Comparte continúa fortaleciendo comunidades mediante proyectos educativos y sociales que generan nuevas oportunidades para niños, jóvenes y familias vulnerables.',

'https://files.diarioportal.com/diarioportal/images/2025/06/4jRnltIt2z7AbRorypsJ3T46f7WXsVzk3aTdKcJW.jpg',

'Equipo Ecuador Comparte',

'2026-05-18T10:00:00',

 'NEWS_STATE_PUBLISHED'
       )ON CONFLICT (id) DO NOTHING;
INSERT INTO news (
    title,
    summary,
    content,
    image_url,
    author,
    publication_date,
    state
)
VALUES (

           'Brigadas médicas rurales en comunidades vulnerables',

           'Jornadas de atención médica y acompañamiento social.',

           'Ecuador Comparte realizó nuevas brigadas médicas en sectores rurales con el objetivo de brindar atención preventiva, orientación familiar y apoyo comunitario a cientos de personas.',

           'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIOpx8W2FV7anuOnP8d5zMTUTJRhkt4SSgJg&s',

           'Fundación Ecuador Comparte',

           '2026-05-19 09:30:00',

           'NEWS_STATE_PUBLISHED'
       )ON CONFLICT (id) DO NOTHING;
INSERT INTO news (
    title,
    summary,
    content,
    image_url,
    author,
    publication_date,
    state
)
VALUES (
           'Talleres de emprendimiento para jóvenes en Quito',

           'Capacitación en habilidades productivas y liderazgo juvenil.',

           'Ecuador Comparte lanzó una nueva serie de talleres de emprendimiento dirigidos a jóvenes entre 16 y 28 años en la ciudad de Quito. Las jornadas incluyen formación en finanzas personales, creación de negocios y desarrollo de habilidades blandas, con el objetivo de generar nuevas oportunidades de trabajo e independencia económica para la juventud ecuatoriana.',

           'https://www.elcomercio.com/wp-content/uploads/2023/04/marketing-digital2-700x391.png',

           'Equipo Ecuador Comparte',

           '2026-05-21 08:00:00',

           'NEWS_STATE_PUBLISHED'
       ) ON CONFLICT (id) DO NOTHING;


-- ============================================================
-- SEED: contact_requests
-- ============================================================
INSERT INTO contact_requests (name, email, phone, purpose, creation_date) VALUES
                                                                              ('Valentina Gómez',    'valentina.gomez@gmail.com',  '+573001234567', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',    NOW()),
                                                                              ('Andrés Martínez',   'andres.martinez@hotmail.com', '+573109876543', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',     NOW()),
                                                                              ('Camila Torres',     'camila.torres@outlook.com',   '+573204567890', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',            NOW()),
                                                                              ('Luis  Ruiz',  'luisfelipe.ruiz@gmail.com',   '+573151122334', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',      NOW()),
                                                                              ('Mariana Herrera',   'mariana.herrera@yahoo.com',   '+573052233445', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',    NOW()),
                                                                              ('Santiago Díaz',     'santiago.diaz@gmail.com',     '+573183344556', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',     NOW()),
                                                                              ('Isabella Moreno',   'isabella.moreno@gmail.com',   '+573124455667', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',            NOW()),
                                                                              ('Daniel Castro',     'daniel.castro@empresa.co',    '+573055566778', 'CONTACT_REQUEST_PURPOSE_EDIFICA_PROGRAM',      NOW())ON CONFLICT (id) DO NOTHING;

-- ============================================================
-- SEED: testimonials
-- ============================================================
INSERT INTO testimonials (name, photo_url, instagram_url, facebook_url, creation_date) VALUES
                                                                                           ('Valentina Gómez',
                                                                                            'https://randomuser.me/api/portraits/women/21.jpg',
                                                                                            'https://instagram.com/valentina.gomez',
                                                                                            'https://facebook.com/valentina.gomez',
                                                                                            NOW()),

                                                                                           ('Andrés Martínez',
                                                                                            'https://randomuser.me/api/portraits/men/34.jpg',
                                                                                            'https://instagram.com/andres.martinez',
                                                                                            NULL,
                                                                                            NOW()),

                                                                                           ('Camila Torres',
                                                                                            'https://randomuser.me/api/portraits/women/45.jpg',
                                                                                            NULL,
                                                                                            'https://facebook.com/camila.torres',
                                                                                            NOW()),

                                                                                           ('Luis Felipe Ruiz',
                                                                                            'https://randomuser.me/api/portraits/men/52.jpg',
                                                                                            'https://instagram.com/luisfelipe.ruiz',
                                                                                            'https://facebook.com/luisfelipe.ruiz',
                                                                                            NOW()),

                                                                                           ('Mariana Herrera',
                                                                                            'https://randomuser.me/api/portraits/women/63.jpg',
                                                                                            'https://instagram.com/mariana.herrera',
                                                                                            NULL,
                                                                                            NOW()),

                                                                                           ('Santiago Díaz',
                                                                                            'https://randomuser.me/api/portraits/men/77.jpg',
                                                                                            NULL,
                                                                                            NULL,
                                                                                            NOW()),

                                                                                           ('Isabella Moreno',
                                                                                            'https://randomuser.me/api/portraits/women/88.jpg',
                                                                                            'https://instagram.com/isabella.moreno',
                                                                                            'https://facebook.com/isabella.moreno',
                                                                                            NOW()),

                                                                                           ('Daniel Castro',
                                                                                            'https://randomuser.me/api/portraits/men/91.jpg',
                                                                                            'https://instagram.com/daniel.castro',
                                                                                            'https://facebook.com/daniel.castro',
                                                                                            NOW())ON CONFLICT (id) DO NOTHING;


